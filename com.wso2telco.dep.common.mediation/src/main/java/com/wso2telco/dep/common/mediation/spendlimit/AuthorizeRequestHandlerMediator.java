/*
 *
 *  Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 * /
 */

package com.wso2telco.dep.common.mediation.spendlimit;


import org.apache.synapse.MessageContext;
import org.apache.synapse.mediators.AbstractMediator;


import java.util.UUID;

public class AuthorizeRequestHandlerMediator extends AbstractMediator {


    /* (non-Javadoc)
     * @see org.apache.synapse.Mediator#mediate(org.apache.synapse.MessageContext)
     */
    public boolean mediate(MessageContext context) {

        log.info("This is handler mediator");
        String transactionId = UUID.randomUUID().toString();
        context.setProperty("uri.var.transactionId", transactionId);

        String restSubRequestPath = (String) context.getProperty("REST_SUB_REQUEST_PATH");
        String queryParamsPart = restSubRequestPath.substring(restSubRequestPath.indexOf('?') + 1);
        String[] queryParams = queryParamsPart.split("&");

        for(String queryParam : queryParams){
            String[] paramKeyValue = queryParam.split("=");
            context.setProperty("uri.var." + paramKeyValue[0], paramKeyValue[1]);
        }

        return true;
    }
}
