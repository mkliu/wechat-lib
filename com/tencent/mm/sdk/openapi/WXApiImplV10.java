package com.tencent.mm.sdk.openapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.tencent.mm.sdk.a.a.b;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.GetMessageFromWX.Req;
import com.tencent.mm.sdk.modelmsg.LaunchFromWX.Req;
import com.tencent.mm.sdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX.Resp;
import com.tencent.mm.sdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.sdk.modelpay.PayResp;

final class WXApiImplV10
  implements IWXAPI
{
  private static final String TAG = "MicroMsg.SDK.WXApiImplV10";
  private Context context;
  private String appId;
  private boolean checkSignature = false;
  private boolean detached = false;
  private static String wxappPayEntryClassname = null;

  WXApiImplV10(Context paramContext, String paramString, boolean paramBoolean)
  {
    com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.WXApiImplV10", "<init>, appId = " + paramString + ", checkSignature = " + paramBoolean);
    this.context = paramContext;
    this.appId = paramString;
    this.checkSignature = paramBoolean;
  }

  public final boolean registerApp(String paramString)
  {
    if (this.detached)
      throw new IllegalStateException("registerApp fail, WXMsgImpl has been detached");
    if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature))
    {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "register app failed for wechat app signature check failed");
      return false;
    }
    com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.WXApiImplV10", "registerApp, appId = " + paramString);
    if (paramString != null)
      this.appId = paramString;
    com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.WXApiImplV10", "register app " + this.context.getPackageName());
    (paramString = new com.tencent.mm.sdk.a.a.a.a()).l = "com.tencent.mm";
    paramString.m = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_REGISTER";
    paramString.j = ("weixin://registerapp?appid=" + this.appId);
    return com.tencent.mm.sdk.a.a.a.a(this.context, paramString);
  }

  public final void unregisterApp()
  {
    if (this.detached)
      throw new IllegalStateException("unregisterApp fail, WXMsgImpl has been detached");
    if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature))
    {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "unregister app failed for wechat app signature check failed");
      return;
    }
    com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.WXApiImplV10", "unregisterApp, appId = " + this.appId);
    if ((this.appId == null) || (this.appId.length() == 0))
    {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "unregisterApp fail, appId is empty");
      return;
    }
    com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.WXApiImplV10", "unregister app " + this.context.getPackageName());
    com.tencent.mm.sdk.a.a.a.a locala;
    (locala = new com.tencent.mm.sdk.a.a.a.a()).l = "com.tencent.mm";
    locala.m = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_UNREGISTER";
    locala.j = ("weixin://unregisterapp?appid=" + this.appId);
    com.tencent.mm.sdk.a.a.a.a(this.context, locala);
  }

  public final boolean handleIntent(Intent paramIntent, IWXAPIEventHandler paramIWXAPIEventHandler)
  {
    if (!WXApiImplComm.isIntentFromWx(paramIntent, "com.tencent.mm.openapi.token"))
    {
      com.tencent.mm.sdk.b.a.b("MicroMsg.SDK.WXApiImplV10", "handleIntent fail, intent not from weixin msg");
      return false;
    }
    if (this.detached)
      throw new IllegalStateException("handleIntent fail, WXMsgImpl has been detached");
    Object localObject = paramIntent.getStringExtra("_mmessage_content");
    int j = paramIntent.getIntExtra("_mmessage_sdkVersion", 0);
    String str;
    if (((str = paramIntent.getStringExtra("_mmessage_appPackage")) == null) || (str.length() == 0))
    {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "invalid argument");
      return false;
    }
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("_mmessage_checksum");
    localObject = b.a((String)localObject, j, str);
    if (!checkSumConsistent(arrayOfByte, (byte[])localObject))
    {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "checksum fail");
      return false;
    }
    int i;
    switch (i = paramIntent.getIntExtra("_wxapi_command_type", 0))
    {
    case 1:
      paramIntent = new SendAuth.Resp(paramIntent.getExtras());
      paramIWXAPIEventHandler.onResp(paramIntent);
      return true;
    case 2:
      paramIntent = new SendMessageToWX.Resp(paramIntent.getExtras());
      paramIWXAPIEventHandler.onResp(paramIntent);
      return true;
    case 3:
      paramIntent = new GetMessageFromWX.Req(paramIntent.getExtras());
      paramIWXAPIEventHandler.onReq(paramIntent);
      return true;
    case 4:
      paramIntent = new ShowMessageFromWX.Req(paramIntent.getExtras());
      paramIWXAPIEventHandler.onReq(paramIntent);
      return true;
    case 5:
      paramIntent = new PayResp(paramIntent.getExtras());
      paramIWXAPIEventHandler.onResp(paramIntent);
      return true;
    case 6:
      paramIntent = new LaunchFromWX.Req(paramIntent.getExtras());
      paramIWXAPIEventHandler.onReq(paramIntent);
      return true;
    }
    com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "unknown cmd = " + i);
    return false;
  }

  public final boolean isWXAppInstalled()
  {
    if (this.detached)
      throw new IllegalStateException("isWXAppInstalled fail, WXMsgImpl has been detached");
    try
    {
      PackageInfo localPackageInfo;
      if ((localPackageInfo = this.context.getPackageManager().getPackageInfo("com.tencent.mm", 64)) == null)
        return false;
      return WXApiImplComm.validateAppSignature(this.context, localPackageInfo.signatures, this.checkSignature);
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return false;
  }

  public final boolean isWXAppSupportAPI()
  {
    if (this.detached)
      throw new IllegalStateException("isWXAppSupportAPI fail, WXMsgImpl has been detached");
    return getWXAppSupportAPI() >= 570490883;
  }

  public final int getWXAppSupportAPI()
  {
    if (this.detached)
      throw new IllegalStateException("getWXAppSupportAPI fail, WXMsgImpl has been detached");
    if (!isWXAppInstalled())
    {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "open wx app failed, not installed or signature check failed");
      return 0;
    }
    return new com.tencent.mm.sdk.a(this.context).getInt("_build_info_sdk_int_", 0);
  }

  public final boolean openWXApp()
  {
    if (this.detached)
      throw new IllegalStateException("openWXApp fail, WXMsgImpl has been detached");
    if (!isWXAppInstalled())
    {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "open wx app failed, not installed or signature check failed");
      return false;
    }
    try
    {
      this.context.startActivity(this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm"));
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "startActivity fail, exception = " + localException.getMessage());
      return false;
    }
    return true;
  }

  public final boolean sendReq(BaseReq paramBaseReq)
  {
    if (this.detached)
      throw new IllegalStateException("sendReq fail, WXMsgImpl has been detached");
    if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature))
    {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "sendReq failed for wechat app signature check failed");
      return false;
    }
    if (!paramBaseReq.checkArgs())
    {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "sendReq checkArgs fail");
      return false;
    }
    com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.WXApiImplV10", "sendReq, req type = " + paramBaseReq.getType());
    Bundle localBundle = new Bundle();
    paramBaseReq.toBundle(localBundle);
    if (paramBaseReq.getType() == 5)
      return sendPayReq(this.context, localBundle);
    (paramBaseReq = new com.tencent.mm.sdk.a.a.a()).k = localBundle;
    paramBaseReq.j = ("weixin://sendreq?appid=" + this.appId);
    paramBaseReq.h = "com.tencent.mm";
    paramBaseReq.i = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
    return com.tencent.mm.sdk.a.a.a(this.context, paramBaseReq);
  }

  private boolean sendPayReq(Context paramContext, Bundle paramBundle)
  {
    if (wxappPayEntryClassname == null)
    {
      wxappPayEntryClassname = new com.tencent.mm.sdk.a(paramContext).getString("_wxapp_pay_entry_classname_", null);
      com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.WXApiImplV10", "pay, set wxappPayEntryClassname = " + wxappPayEntryClassname);
      if (wxappPayEntryClassname == null)
      {
        com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "pay fail, wxappPayEntryClassname is null");
        return false;
      }
    }
    com.tencent.mm.sdk.a.a.a locala;
    (locala = new com.tencent.mm.sdk.a.a.a()).k = paramBundle;
    locala.h = "com.tencent.mm";
    locala.i = wxappPayEntryClassname;
    return com.tencent.mm.sdk.a.a.a(paramContext, locala);
  }

  public final boolean sendResp(BaseResp paramBaseResp)
  {
    if (this.detached)
      throw new IllegalStateException("sendResp fail, WXMsgImpl has been detached");
    if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature))
    {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "sendResp failed for wechat app signature check failed");
      return false;
    }
    if (!paramBaseResp.checkArgs())
    {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "sendResp checkArgs fail");
      return false;
    }
    Bundle localBundle = new Bundle();
    paramBaseResp.toBundle(localBundle);
    (paramBaseResp = new com.tencent.mm.sdk.a.a.a()).k = localBundle;
    paramBaseResp.j = ("weixin://sendresp?appid=" + this.appId);
    paramBaseResp.h = "com.tencent.mm";
    paramBaseResp.i = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
    return com.tencent.mm.sdk.a.a.a(this.context, paramBaseResp);
  }

  public final void detach()
  {
    com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.WXApiImplV10", "detach");
    this.detached = true;
    this.context = null;
  }

  private boolean checkSumConsistent(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0) || (paramArrayOfByte2 == null) || (paramArrayOfByte2.length == 0))
    {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "checkSumConsistent fail, invalid arguments");
      return false;
    }
    if (paramArrayOfByte1.length != paramArrayOfByte2.length)
    {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "checkSumConsistent fail, length is different");
      return false;
    }
    for (int i = 0; i < paramArrayOfByte1.length; i++)
      if (paramArrayOfByte1[i] != paramArrayOfByte2[i])
        return false;
    return true;
  }
}

/* Location:           /Users/wayliu/git/wechat-sdk-sample/amm_sdk_sample/libs/libammsdk 2.jar
 * Qualified Name:     com.tencent.mm.sdk.openapi.WXApiImplV10
 * JD-Core Version:    0.6.2
 */