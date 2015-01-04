package com.tencent.mm.sdk.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.a.a.b;
import com.tencent.mm.sdk.b.c;

public final class a
{
  public static boolean a(Context paramContext, a parama)
  {
    if ((paramContext == null) || (parama == null))
    {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessageAct", "send fail, invalid argument");
      return false;
    }
    if (c.a(parama.h))
    {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessageAct", "send fail, invalid targetPkgName, targetPkgName = " + parama.h);
      return false;
    }
    if (c.a(parama.i))
      parama.i = (parama.h + ".wxapi.WXEntryActivity");
    com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.MMessageAct", "send, targetPkgName = " + parama.h + ", targetClassName = " + parama.i);
    Intent localIntent;
    (localIntent = new Intent()).setClassName(parama.h, parama.i);
    if (parama.k != null)
      localIntent.putExtras(parama.k);
    String str = paramContext.getPackageName();
    localIntent.putExtra("_mmessage_sdkVersion", 570490883);
    localIntent.putExtra("_mmessage_appPackage", str);
    localIntent.putExtra("_mmessage_content", parama.j);
    localIntent.putExtra("_mmessage_checksum", b.a(parama.j, 570490883, str));
    if (parama.flags == -1)
      localIntent.addFlags(268435456).addFlags(134217728);
    else
      localIntent.setFlags(parama.flags);
    try
    {
      paramContext.startActivity(localIntent);
    }
    catch (Exception paramContext)
    {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessageAct", "send fail, ex = %s", new Object[] { paramContext.getMessage() });
      return false;
    }
    com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.MMessageAct", "send mm message, intent=" + localIntent);
    return true;
  }

  public static class a
  {
    public String h;
    public String i;
    public String j;
    public int flags = -1;
    public Bundle k;
  }
}

/* Location:           /Users/wayliu/git/wechat-sdk-sample/amm_sdk_sample/libs/libammsdk 2.jar
 * Qualified Name:     com.tencent.mm.sdk.a.a
 * JD-Core Version:    0.6.2
 */