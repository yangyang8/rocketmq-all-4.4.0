/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.rocketmq.client.producer;

import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.common.message.MessageQueue;


/**
 * 消息发送结果
 *
 * [SendResult [sendStatus=SEND_OK,
 * msgId=C0A81FDA210018B4AAC25F1C1D320000,
 * offsetMsgId=C0A81FDA00002A9F000000000006AA26,
 * messageQueue=MessageQueue [topic=topic_test, brokerName=PC-20170327WDKR, queueId=2], queueOffset=0]]
 *
 *
 */
public class SendResult {
    //生产者发送消息的状态
    private SendStatus sendStatus;
    private String msgId;//消息编号
    private MessageQueue messageQueue;//消息队列
    private long queueOffset;//队列的偏移量
    private String transactionId;//事务编号
    private String offsetMsgId;//消息偏移量
    private String regionId;//区域编号
    private boolean traceOn = true;

    public SendResult() {
    }

    public SendResult(SendStatus sendStatus, String msgId, String offsetMsgId, MessageQueue messageQueue,
        long queueOffset) {
        this.sendStatus = sendStatus;
        this.msgId = msgId;
        this.offsetMsgId = offsetMsgId;
        this.messageQueue = messageQueue;
        this.queueOffset = queueOffset;
    }

    public SendResult(final SendStatus sendStatus, final String msgId, final MessageQueue messageQueue,
        final long queueOffset, final String transactionId,
        final String offsetMsgId, final String regionId) {
        this.sendStatus = sendStatus;
        this.msgId = msgId;
        this.messageQueue = messageQueue;
        this.queueOffset = queueOffset;
        this.transactionId = transactionId;
        this.offsetMsgId = offsetMsgId;
        this.regionId = regionId;
    }

    public static String encoderSendResultToJson(final Object obj) {
        return JSON.toJSONString(obj);
    }

    public static SendResult decoderSendResultFromJson(String json) {
        return JSON.parseObject(json, SendResult.class);
    }

    public boolean isTraceOn() {
        return traceOn;
    }

    public void setTraceOn(final boolean traceOn) {
        this.traceOn = traceOn;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(final String regionId) {
        this.regionId = regionId;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public SendStatus getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(SendStatus sendStatus) {
        this.sendStatus = sendStatus;
    }

    public MessageQueue getMessageQueue() {
        return messageQueue;
    }

    public void setMessageQueue(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    public long getQueueOffset() {
        return queueOffset;
    }

    public void setQueueOffset(long queueOffset) {
        this.queueOffset = queueOffset;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOffsetMsgId() {
        return offsetMsgId;
    }

    public void setOffsetMsgId(String offsetMsgId) {
        this.offsetMsgId = offsetMsgId;
    }

    @Override
    public String toString() {
        return "SendResult [sendStatus=" + sendStatus + ", msgId=" + msgId + ", offsetMsgId=" + offsetMsgId + ", messageQueue=" + messageQueue
            + ", queueOffset=" + queueOffset + "]";
    }
}
