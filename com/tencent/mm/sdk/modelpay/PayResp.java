package com.tencent.mm.sdk.modelpay;

import android.os.Bundle;
import com.tencent.mm.sdk.modelbase.BaseResp;

public class PayResp extends BaseResp
{
  public String prepayId;
  public String returnKey;
  public String extData;

  public PayResp()
  {
  }

  public PayResp(Bundle paramBundle)
  {
    fromBundle(paramBundle);
  }

  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_payresp_prepayid", this.prepayId);
    paramBundle.putString("_wxapi_payresp_returnkey", this.returnKey);
    paramBundle.putString("_wxapi_payresp_extdata", this.extData);
  }

  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.prepayId = paramBundle.getString("_wxapi_payresp_prepayid");
    this.returnKey = paramBundle.getString("_wxapi_payresp_returnkey");
    this.extData = paramBundle.getString("_wxapi_payresp_extdata");
  }

  public int getType()
  {
    return 5;
  }

  public boolean checkArgs()
  {
    return true;
  }
}

/* Location:           /Users/wayliu/git/wechat-sdk-sample/amm_sdk_sample/libs/libammsdk 2.jar
 * Qualified Name:     com.tencent.mm.sdk.modelpay.PayResp
 * JD-Core Version:    0.6.2
 */