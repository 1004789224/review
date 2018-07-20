package com.company.thread.singleton;

/**
 * @author lw
 * @version 1.0
 * @description com.company.thread
 * @date 2018/7/20
 */

/**
 * 饿汉单例模式
 * 在类加载时,完成类得初始化
 * 避免了多线程得同步问题
 * 但未实现延迟加载
 * public class Singleton {
 *     private static Singleton instance =new Singleton();
 *
 *     public static Singleton getInstance(){
 *         return instance;
 *     }
 *
 *     private Singleton() {
 *
 *     }
 * }
 */

/**
 * 懒汉单例,线程不安全
 * public class Singleton{
 *     private static Singleton instance=null;
 *     public static Singleton getInstance(){
 *         if (instance == null) {
 *             instance = new Singleton();
 *         }
 *         return instance;
 *
 *     }
 *
 *     private Singleton(){}
 * }
 */

/**
 * 懒汉单例模式,线程安全但使用synchronized效率低
 * 下面得代码使用同步方法,已经解决了懒汉式的线程安全问题,
 * 但是synchronized的作用域太大了,损耗性能------->注意尽量减小synchronized的作用域.
 * public class Singleton {
 *     private static Singleton instance;
 *     private Singleton (){}
 *     public static synchronized Singleton getInstance() {
 *         if (instance == null) {
 *             instance = new Singleton();
 *         }
 *         return instance;
 *     }
 * }
 */
/**
 * 懒汉单例变种  双重检验锁
 * 先检验instance是否为空 不为空直接换回 这一步未第一重检验,可以避免同步快效率低的问题
 * 在进入同步快后  在检验一次instance是否为空 为空则生成实例,否则返回
 * 线程安全,且实现延迟加载
 * 被volatile修饰的变量的值，
 * 将不会被本地线程缓存，
 * 所有对该变量的读写都是直接操作共享内存，从而确保多个线程能正确的处理该变量。
 * volatile关键字可能会屏蔽掉虚拟机中一些必要的代码优化，所以运行效率并不是很高
 * public class Singleton{
 *     private volatile static Singleton instance=null;
 *     public static Singleton getInstance() {
 *         if (instance == null) {
 *             synchronized (Singleton.class) {
 *                 if (instance == null) {
 *                     instance = new Singleton();
 *                 }
 *             }
 *         }
 *         return instance;
 *     }
 * }
 */

/**
 *这种方式Singleton类被装载了，instance不一定被初始化。
 * 因为SingletonHolder类没有被主动使用，只有显示通过调用getInstance方法时，
 * 才会显示装载SingletonHolder类，从而实例化instance。
 * 想象一下，如果实例化instance很消耗资源，我想让他延迟加载，另外一方面，
 * 我不希望在Singleton类加载时就实例化，因为我不能确保Singleton类还可能在其他
 * 的地方被主动使用从而被加载，那么这个时候实例化instance显然是不合适的。
 * public class Singleton {
 *     private static class SingletonHolder {
 *         private static final Singleton INSTANCE = new Singleton();
 *     }
 *     private Singleton (){}
 *     public static final Singleton getInstance() {
 *         return SingletonHolder.INSTANCE;
 *     }
 * }
 */

/**
 * 推荐方式 线程安全
 * 1. 代码简单
 * 2. 自由序列化
 * public enum Singleton {
 *     INSTANCE;
 * }
 */

class main{
    public static void main(String[]args){
    }
}



