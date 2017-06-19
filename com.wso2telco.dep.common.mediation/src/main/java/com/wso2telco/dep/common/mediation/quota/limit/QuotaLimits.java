/*******************************************************************************
 * Copyright (c) 2015-2017, WSO2.Telco Inc. (http://www.wso2telco.com)
 *
 * All Rights Reserved. WSO2.Telco Inc. licences this file to you under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.wso2telco.dep.common.mediation.quota.limit;


public class QuotaLimits {

    private int spLimit;
    private int appLimit;
    private int apiLimit;

    public static QuotaLimits getQuotaLimitsObj(){

        return new QuotaLimits();
    }

    public int getSpLimit() {
        return spLimit;
    }

    public void setSpLimit(int spLimit) {
        this.spLimit = spLimit;
    }

    public int getAppLimit() {
        return appLimit;
    }

    public void setAppLimit(int appLimit) {
        this.appLimit = appLimit;
    }

    public int getApiLimit() {
        return apiLimit;
    }

    public void setApiLimit(int apiLimit) {
        this.apiLimit = apiLimit;
    }
}
