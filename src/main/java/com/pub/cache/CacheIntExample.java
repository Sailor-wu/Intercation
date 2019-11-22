package com.pub.cache;

public class CacheIntExample {
	//考虑一般缓存行大小是64字节，一个 long 类型占8字节
    static  int [][] arr;
 
    public static void main(String[] args) {
//        arr = new int[1024 * 1024][8];
//        for (int i = 0; i < 1024 * 1024; i++) {
//            arr[i] = new int[8];
//            for (int j = 0; j < 8; j++) {
//                arr[i][j] = 0;
//            }
//        }
//        int sum = 0;
//        long marked = System.currentTimeMillis();
//        for (int i = 0; i < 1024 * 1024; i+=1) {
//            for(int j =0; j< 8;j++){
//                sum = arr[i][j];
//            }
//        }
//        System.out.println("Loop times:" + (System.currentTimeMillis() - marked) + "ms");
// 
//        marked = System.currentTimeMillis();
//        for (int i = 0; i < 8; i+=1) {
//            for(int j =0; j< 1024 * 1024;j++){
//                sum = arr[j][i];
//            }
//        }
//        System.out.println("Loop times:" + (System.currentTimeMillis() - marked) + "ms");
        
//    	 arr = new int[64*64*64][64];
//         for (int i = 0; i < 64*64*64; i++) {
//             arr[i] = new int[64];
//             for (int j = 0; j < 64; j++) {
//                 arr[i][j] = 0;
//             }
//         }
//         int sum = 0;
//         long marked = System.currentTimeMillis();
//         for (int i = 0; i < 64*64*64; i+=1) {
//             for(int j =0; j< 64;j++){
//                 sum = arr[i][j];
//             }
//         }
//         System.out.println("Loop times:" + (System.currentTimeMillis() - marked) + "ms");
//  
//         marked = System.currentTimeMillis();
//         for (int i = 0; i < 64; i+=1) {
//             for(int j =0; j< 64*64*64;j++){
//                 sum = arr[j][i];
//             }
//         }
//         System.out.println("Loop times:" + (System.currentTimeMillis() - marked) + "ms");
//        
         
    	
    	
//    	arr = new int[64][64*64*64];
//    	
//        for (int i = 0; i < 64; i++) {
//            arr[i] = new int[64*64*64];
//            for (int j = 0; j < 64*64*64; j++) {
//                arr[i][j] = 0;
//            }
//        }
//        
//        int sum = 0;
//        long marked = System.currentTimeMillis();
//        for (int i = 0; i < 64; i+=1) {
//            for(int j =0; j< 64*64*64;j++){
//                sum = arr[i][j];
//            }
//        }
//        System.out.println("Loop times:" + (System.currentTimeMillis() - marked) + "ms");
// 
//        marked = System.currentTimeMillis();
//        for (int i = 0; i < 64*64*64; i+=1) {
//            for(int j =0; j< 64;j++){
//                sum = arr[j][i];
//            }
//        }
//        System.out.println("Loop times:" + (System.currentTimeMillis() - marked) + "ms");
    	
    	
    	arr = new int[800000][2];
      for (int i = 0; i < 800000; i++) {
          arr[i] = new int[2];
          for (int j = 0; j < 2; j++) {
              arr[i][j] = 0;
          }
      }
      int sum = 0;
      long marked = System.currentTimeMillis();
      for (int i = 0; i < 800000; i+=1) {
          for(int j =0; j< 2;j++){
              sum = arr[i][j];
          }
      }
      System.out.println("Loop times:" + (System.currentTimeMillis() - marked) + "ms");

      marked = System.currentTimeMillis();
      for (int i = 0; i < 2; i+=1) {
          for(int j =0; j< 800000;j++){
              sum = arr[j][i];
          }
      }
      System.out.println("Loop times:" + (System.currentTimeMillis() - marked) + "ms");
       
    }
}
