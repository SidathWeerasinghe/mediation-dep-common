/**
 * Copyright (c) 2016, WSO2.Telco Inc. (http://www.wso2telco.com) All Rights Reserved.
 *
 * WSO2.Telco Inc. licences this file to you under the Apache License, Version 2.0 (the "License");
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
 */

package com.wso2telco.dep.common.mediation.spendlimit.publisher;

import com.wso2telco.dep.common.mediation.spendlimit.messageenum.PaymentType;
import org.json.JSONException;
import org.json.JSONObject;

public class PublishFactory {
	static RefundPublisher refundPub;
	static ChargePublisher chargePub;

	public static Publishable getPublishable(JSONObject paymentRes) throws JSONException {


		PaymentType publishType = PaymentType.get(paymentRes.getString("transactionOperationStatus"));
		Publishable publishable =null;
		synchronized (publishType) {
			switch (publishType) {
				case CHARGED:
					if(chargePub==null){
						chargePub = new ChargePublisher();
					}
					publishable =chargePub;
					break;

				case REFUND:
					if(refundPub==null){
						refundPub = new RefundPublisher();
					}
					publishable = refundPub;
					break;
				default:
					break;
			}
		}

		return publishable;
	}
}
