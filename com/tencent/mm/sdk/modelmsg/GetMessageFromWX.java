package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;

public final class GetMessageFromWX
{
  public static class Resp extends BaseResp
  {
    private static final String TAG = "MicroMsg.SDK.GetMessageFromWX.Resp";
    public WXMediaMessage message;

    public Resp()
    {
    }

    public Resp(Bundle paramBundle)
    {
      fromBundle(paramBundle);
    }

    public int getType()
    {
      return 3;
    }

    public void fromBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
      this.message = WXMediaMessage.Builder.fromBundle(paramBundle);
    }

    public void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
      paramBundle.putAll(WXMediaMessage.Builder.toBundle(this.message));
    }

    public boolean checkArgs()
    {
      if (this.message == null)
      {
        a.a("MicroMsg.SDK.GetMessageFromWX.Resp", "checkArgs fail, message is null");
        return false;
      }
      return this.message.checkArgs();
    }
  }

  public static class Req extends BaseReq
  {
    public String username;

    public Req()
    {
    }

    public Req(Bundle paramBundle)
    {
      fromBundle(paramBundle);
    }

    public int getType()
    {
      return 3;
    }

    public void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
    }

    public void fromBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
    }

    public boolean checkArgs()
    {
      return true;
    }
  }
}

/* Location:           /Users/wayliu/git/wechat-sdk-sample/amm_sdk_sample/libs/libammsdk 2.jar
 * Qualified Name:     com.tencent.mm.sdk.modelmsg.GetMessageFromWX
 * JD-Core Version:    0.6.2
 */