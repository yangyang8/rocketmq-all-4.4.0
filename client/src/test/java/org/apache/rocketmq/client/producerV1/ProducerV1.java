package org.apache.rocketmq.client.producerV1;


import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * 发送信息测试类
 */
public class ProducerV1 {


    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {

        //先创建一个默认的推送信息
        //quickstart_test_product_name 这个一定要写，不写的话，会检测到生产者组没有名称，有报错
        DefaultMQProducer producer=new DefaultMQProducer("quickstart_test_product_name");//DEFAULT_PRODUCER
//        DefaultMQProducer producer=new DefaultMQProducer("DEFAULT_PRODUCER");//

        //进行设置NameServer_Add地址
        producer.setNamesrvAddr("192.168.31.218:9876");

        //进行开启生产都
        producer.start();

        //进行开始发送消息
        for (int i=0;i<5;i++){
            //创建消息对象
            //String topic, String tags, String keys, int flag, byte[] body, boolean waitStoreMsgOK
            Message message = new Message("topic_test",//主题
                    "Tag" + i, "KEY+" + i, ("Hello RocketMQ-"+i).getBytes());

            //进行发送
            SendResult send = producer.send(message);

            //得到发送消息的结果
            System.out.println("发送消息结果 = [" + send + "]");
        }



    }
}
