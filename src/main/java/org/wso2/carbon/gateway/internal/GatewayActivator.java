/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */

package org.wso2.carbon.gateway.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.wso2.carbon.gateway.internal.transport.listener.GatewayNettyInitializer;
import org.wso2.carbon.transport.http.netty.listener.CarbonNettyServerInitializer;

import java.util.Hashtable;

/**
 * OSGi Bundle Activator of the gateway Carbon component.
 */
public class GatewayActivator implements BundleActivator {
    private static final String CHANNEL_ID_KEY = "channel.id";

    public void start(BundleContext bundleContext) throws Exception {
        Hashtable<String, String> httpInitParams = new Hashtable<>();
        httpInitParams.put(CHANNEL_ID_KEY, "netty-gw");
        GatewayNettyInitializer gatewayNettyInitializer = new GatewayNettyInitializer();
        bundleContext.registerService(CarbonNettyServerInitializer.class, gatewayNettyInitializer, httpInitParams);
    }

    public void stop(BundleContext bundleContext) throws Exception {

    }

}

