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
package com.alipay.sofa.ark.webflux.embed.netty;

import com.alipay.sofa.ark.spi.web.EmbeddedServerService;
import io.netty.channel.Channel;

/**
 * This implementation would be published as ark service.
 *
 * @author qilong.zql
 * @since 0.6.0
 */
public class EmbeddedServerServiceImpl implements EmbeddedServerService<Channel> {
    private Channel netty;
    private final Object lock = new Object();

    @Override
    public Channel getEmbedServer() {
        return netty;
    }

    @Override
    public void setEmbedServer(Channel netty) {
        if (this.netty == null) {
            synchronized (lock) {
                if (this.netty == null) {
                    this.netty = netty;
                }
            }
        }
    }
}