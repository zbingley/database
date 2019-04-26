package com.limai.database.rabbitMQ.pubsub.fanout;

import com.limai.database.common.constant.MQField;
import com.limai.database.rabbitMQ.dto.GoodsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Author: zhangbin
 * @Date: 2018/11/7 13:26
 * @Desc:
 */
@Component
@Slf4j
public class FanoutSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    public boolean sendGoods(GoodsVo goodsVo){
        boolean isOK=false;
        if(Objects.isNull(goodsVo)){
            log.error("消息为空");
            return isOK;
        }
        rabbitTemplate.convertAndSend(MQField.MY_FANOUT_EXCHANGE,"",goodsVo);
        isOK=true;
        log.info("FanoutSender发送对象消息结果：{}",isOK);
        return isOK;
    }
}
