package org.simon.curator.demo01;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.framework.recipes.leader.LeaderLatchListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 你搞忘写注释了
 *
 * @author zhang_zhang
 * @date 2020-09-29
 * @since 2.4.2
 */
public class Demo01 {

    private CuratorFramework client;

    @Before
    public void init(){
        RetryPolicy retryPolicy  = new ExponentialBackoffRetry(1000,3);
        client = CuratorFrameworkFactory.builder()
                .connectString("127.0.0.1:2181")
                .sessionTimeoutMs(3000)
                .connectionTimeoutMs(5000)
                .retryPolicy(retryPolicy)
                .build();
        client.start();
        System.out.println(client);
    }

    @Test
    public void test01() throws Exception {


        client.create().forPath("/demo","我是内容".getBytes());

    }


    @Test
    public void test02() throws Exception {
        String ret = new String(client.getData().forPath("/demo"));
        // 包含状态查询
        Stat stat = new Stat();
        client.getData().storingStatIn(stat).forPath("/demo");
        System.out.println(stat);

        client.setData()/*.withVersion(0)*/.forPath("/demo", "new111".getBytes());
    }



    @Test
    public void leaderLatch01() {
        String node = "node-01";
        //添加选举监听
        LeaderLatch leaderLatch = new LeaderLatch(client, "/leader", node);
        try {

            leaderLatch.addListener(new LeaderLatchListener() {
                @Override
                public void isLeader() {
                    // 如果成为master则触发
                    System.out.println("is leader");
                }

                @Override
                public void notLeader() {
                    // 如果从主节点变成非主节点则触发
                    System.out.println("not leader");
                }
            });

            //加入选举
            leaderLatch.start();
            // 这里需要等待才能得到结果，，模拟多个client需要运行多个test方法，前面的client调用start（）后需要休眠等待后几个client加入选举，
            // ，因此前面的不用注释Thread.sllep，后面的注释掉立即进入选举。


            TimeUnit.SECONDS.sleep(10);
            System.out.println(leaderLatch.hasLeadership());


            //阻塞直到当前节点master
            leaderLatch.await();
            System.out.println("====is master");

            TimeUnit.SECONDS.sleep(10);
            leaderLatch.close();
            System.out.println(node+":退出选举");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                leaderLatch.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void leaderLatch02() {
        String node = "node-02";
        //添加选举监听
        LeaderLatch leaderLatch = new LeaderLatch(client, "/leader", node);
        try {

            leaderLatch.addListener(new LeaderLatchListener() {
                @Override
                public void isLeader() {
                    // 如果成为master则触发
                    System.out.println("is leader");
                }

                @Override
                public void notLeader() {
                    // 如果从主节点变成非主节点则触发
                    System.out.println("not leader");
                }
            });

            //加入选举
            leaderLatch.start();
            // 这里需要等待才能得到结果，，模拟多个client需要运行多个test方法，前面的client调用start（）后需要休眠等待后几个client加入选举，
            // ，因此前面的不用注释Thread.sllep，后面的注释掉立即进入选举。


            TimeUnit.SECONDS.sleep(10);
            System.out.println(leaderLatch.hasLeadership());


            //阻塞直到当前节点master
            leaderLatch.await();
            System.out.println("====is master");

            TimeUnit.SECONDS.sleep(10);
            leaderLatch.close();
            System.out.println(node+":退出选举");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                leaderLatch.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    private static String           path    = "/master";
    private static String           id = "0001";

    public void test03() throws Exception {
        // curator客户端启动
        client.start();
        // 创建选举实例
        LeaderLatch latch = new LeaderLatch(client, path, id);


        // 加入选举
        latch.start();
        // curator客户端关闭
        client.close();
    }

}