package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;

public class ShowMessageFromWX
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
      return 4;
    }

    public boolean checkArgs()
    {
      return true;
    }
  }

  public static class Req extends BaseReq
  {
    public WXMediaMessage message;

    public Req()
    {
    }

    public Req(Bundle paramBundle)
    {
      fromBundle(paramBundle);
    }

    public int getType()
    {
      return 4;
    }

    public void toBundle(Bundle paramBundle)
    {
      Bundle localBundle = WXMediaMessage.Builder.toBundle(this.message);
      super.toBundle(localBundle);
      paramBundle.putAll(localBundle);
    }

    public void fromBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
      this.message = WXMediaMessage.Builder.fromBundle(paramBundle);
    }

    public boolean checkArgs()
    {
      if (this.message == null)
        return false;
      return this.message.checkArgs();
    }
  }
}

/* Location:           /Users/wayliu/git/wechat-sdk-sample/amm_sdk_sample/libs/libammsdk 2.jar
 * Qualified Name:     com.tencent.mm.sdk.modelmsg.ShowMessageFromWX
 * JD-Core Version:    0.6.2
 */