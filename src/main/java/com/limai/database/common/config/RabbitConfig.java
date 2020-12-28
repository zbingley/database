package com.limai.database.common.config;


import org.springframework.context.annotation.Configuration;

/**
 * @Author: zhangbin
 * @Date: 2018/11/6 16:19
 * @Desc: 消息队列配置类
 */
@Configuration
public class RabbitConfig {

//    @Bean
//    public Queue stringQueue(){
//        //默认值：
//        /*boolean isDurable=true;//是否持久化
//        boolean isExclusive=false;//仅创建者可以使用的私有队列，连接断开后自动删除
//        boolean isAutoDelete=false;//当所有消费者客户端断开后，是否删除队列
//
//        Queue queue = new Queue(MQField.HELLO_STRING_QUEUE, isDurable, isExclusive, isAutoDelete);
//        return queue;*/
//        return new Queue(MQField.HELLO_STRING_QUEUE);
//        /*return QueueBuilder
//                .durable(MQField.HELLO_STRING_QUEUE)
//                .build();*/
//    }
//    @Bean
//    public Queue goodsQueue(){
//        return QueueBuilder
//                .durable(MQField.HELLO_GOODS_QUEUE)
//                .build();
//    }
//    @Bean
//    public Queue workerQueue(){
//        return QueueBuilder
//                .durable(MQField.MY_WORKER_QUEUE)
//                .build();
//    }
//    @Bean
//    public Queue fanoutAQueue(){
//        return QueueBuilder
//                .durable(MQField.MY_FANOUTA_QUEUE)
//                .build();
//    }
//    @Bean
//    public Queue fanoutBQueue(){
//        return QueueBuilder
//                .durable(MQField.MY_FANOUTB_QUEUE)
//                .build();
//    }
//    @Bean
//    public FanoutExchange fanoutExchange(){
//        return (FanoutExchange) ExchangeBuilder
//                .fanoutExchange(MQField.MY_FANOUT_EXCHANGE)
//                .build();
////        return new  FanoutExchange(MQField.MY_FANOUT_EXCHANGE);
//    }
//    @Bean
//    public Binding bindingExchangeA( Queue fanoutAQueue,FanoutExchange fanoutExchange){
//        return BindingBuilder
//                .bind(fanoutAQueue)
//                .to(fanoutExchange);
//
//    }
//    @Bean
//    public Binding bindingExchangeB(Queue fanoutBQueue,FanoutExchange fanoutExchange){
//        return BindingBuilder
//                .bind(fanoutBQueue)
//                .to(fanoutExchange);
//    }
//    @Bean
//    public Queue topicAQueue(){
//        return QueueBuilder
//                .durable(MQField.MY_TOPICA_QUEUE)
//                .build();
//    }
//    @Bean
//    public Queue topicBQueue(){
//        return QueueBuilder
//                .durable(MQField.MY_TOPICB_QUEUE)
//                .build();
//    }
//    @Bean
//    public TopicExchange topicExchange(){
//        return (TopicExchange) ExchangeBuilder
//                .topicExchange(MQField.MY_TOPIC_EXCHANGE)
//                .build();
//    }
//    @Bean
//    public Binding bindingTopicAExchangeMessage(Queue topicAQueue, TopicExchange topicExchange ){
//        return BindingBuilder
//                .bind(topicAQueue)
//                .to(topicExchange)
//                .with(MQField.MY_TOPIC_BINGDINGKEYA);
//    }
//    @Bean
//    public Binding bindingTopicBExchangeMessage(Queue topicBQueue, TopicExchange topicExchange ){
//        return BindingBuilder
//                .bind(topicBQueue)
//                .to(topicExchange)
//                .with(MQField.MY_TOPIC_BINGDINGKEYB);
//    }
//    @Bean
//    public Queue directAQueue(){
//        return QueueBuilder
//                .durable(MQField.MY_DIRECTA_QUEUE)
//                .build();
//    }
//    @Bean
//    public Queue directBQueue(){
//        return QueueBuilder
//                .durable(MQField.MY_DIRECTB_QUEUE)
//                .build();
//    }
//    @Bean
//    public DirectExchange directExchange(){
//        return (DirectExchange) ExchangeBuilder
//                .directExchange(MQField.MY_DIRECT_EXCHANGE)
//                .durable(true)
//                .build();
//    }
//    @Bean
//    public Binding bindingDirectAExchangeMessage(Queue directAQueue,DirectExchange directExchange){
//        return BindingBuilder
//                .bind(directAQueue)
//                .to(directExchange)
//                .with(MQField.MY_DIRECT_ROUTINGKEYA);
//    }
//    @Bean
//    public Binding bindingDirectBExchangeMessage(Queue directBQueue,DirectExchange directExchange){
//        return BindingBuilder
//                .bind(directBQueue)
//                .to(directExchange)
//                .with(MQField.MY_DIRECT_ROUTINGKEYB);
//    }
}
