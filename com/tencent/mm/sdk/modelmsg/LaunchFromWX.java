package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;

public class LaunchFromWX
{
  public static class Resp extends BaseResp
  {
    public Resp()
    {
    }

    public Resp(Bundle paramBundle)
    {
      fromBundle(paramBundle);
    }

    public int getType()
    {
      return 6;
    }

    public boolean checkArgs()
    {
      return true;
    }
  }

  public static class Req extends BaseReq
  {
    public Req()
    {
    }

    public Req(Bundle paramBundle)
    {
      fromBundle(paramBundle);
    }

    public int getType()
    {
      return 6;
    }

    public boolean checkArgs()
    {
      return true;
    }
  }
}

/* Location:           /Users/wayliu/git/wechat-sdk-sample/amm_sdk_sample/libs/libammsdk 2.jar
 * Qualified Name:     com.tencent.mm.sdk.modelmsg.LaunchFromWX
 * JD-Core Version:    0.6.2
 */