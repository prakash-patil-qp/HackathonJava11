package com.questionpro.db.factory;

import com.questionpro.db.command.TableOperation;
import com.questionpro.db.handler.QueryHandler;

public class HandlerFactory {
    private static HandlerFactory handlerFactory = new HandlerFactory();

    private HandlerFactory() {

    }

    public static HandlerFactory getInstance() {
        return handlerFactory;
    }


    public QueryHandler getQueryHandler(Enum<TableOperation> operationType) {

        switch (operationType) {
            case TableOperation.CREATE.getValue():
                return new AmazonRewardHandler(rewardType, survey);
            case SurveySetting.REWARD_ID_STAR_BUCKS_GIFT_CARD:
                return new StarbucksRewardHandler(rewardType, survey);
            case SurveySetting.REWARD_ID_TANGO_GIFT_CARD:
                return new TangoCardRewardHandler(rewardType, survey);
            case SurveySetting.REWARD_ID_VIRTUAL_VISA_CARD:
                return new VisaCardRewardHandler(rewardType, survey);
            case SurveySetting.REWARD_ID_COUPON:
                return new CouponsRewardHandler(rewardType, survey);
            case SurveySetting.REWARD_ID_USER_DEFINED:
                return new UserDefinedAndFulfilledRewardHandler(rewardType, survey);
            default:
                return null;
        }
    }
}
