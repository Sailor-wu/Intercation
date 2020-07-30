package com.leetcode;

import java.util.HashMap;
import java.util.Map;
/**
 * 特殊邮件地址
 * @author W.hy
 *
 */
public class EmailAddress {

	public static void main(String[] args) {
//		String [] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
		String [] emails = {"test.email+alex@leetcode.com", "test.email@leetcode.com"};
		System.out.println(new EmailAddress().numUniqueEmails(emails));
	}
	
	public int numUniqueEmails1(String[] emails) {
        Map<String,String> emailMap = new HashMap<String,String>();
        String email;
        String prefix;
        String key;
        for(int i = 0; i < emails.length;i++){
            email = emails[i];
            // 切分本地和域名
            int index_e = email.indexOf('@');
			prefix = email.substring(0,index_e);
			// 操作本地部分
            prefix = prefix.replaceAll("\\.", "");
            int index_ = prefix.indexOf('+');
			if(index_ != -1){
                prefix = prefix.substring(0,index_);
            }
            key = prefix+email.substring(index_e,email.length());
			emailMap.put(key,key);
        }
        return emailMap.size();
    }
	
	public int numUniqueEmails(String[] emails) {
        Map<String,Integer> emailMap = new HashMap<String,Integer>();
        String email;
        String prefix;
        String key;
        for(int i = 0; i < emails.length;i++){
            email = emails[i];
            // 切分本地和域名
			prefix = email.substring(0, email.indexOf('@'));
			// 操作本地部分
            prefix = prefix.replaceAll("\\.", "");
			if(prefix.indexOf('+') != -1){
                prefix = prefix.substring(0,prefix.indexOf('+'));
            }
            key = prefix+email.substring(email.indexOf('@'));
			emailMap.put(key,i);
        }
        return emailMap.size();
    }
}
