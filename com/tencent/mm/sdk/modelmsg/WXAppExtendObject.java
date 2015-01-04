package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import java.io.File;

public class WXAppExtendObject
  implements WXMediaMessage.IMediaObject
{
  private static final String TAG = "MicroMsg.SDK.WXAppExtendObject";
  private static final int EXTINFO_LENGTH_LIMIT = 2048;
  private static final int PATH_LENGTH_LIMIT = 10240;
  private static final int CONTENT_LENGTH_LIMIT = 10485760;
  public String extInfo;
  public String filePath;
  public byte[] fileData;

  public WXAppExtendObject()
  {
  }

  public WXAppExtendObject(String paramString, byte[] paramArrayOfByte)
  {
    this.extInfo = paramString;
    this.fileData = paramArrayOfByte;
  }

  public WXAppExtendObject(String paramString1, String paramString2)
  {
    this.extInfo = paramString1;
    this.filePath = paramString2;
  }

  public void serialize(Bundle paramBundle)
  {
    paramBundle.putString("_wxappextendobject_extInfo", this.extInfo);
    paramBundle.putByteArray("_wxappextendobject_fileData", this.fileData);
    paramBundle.putString("_wxappextendobject_filePath", this.filePath);
  }

  public void unserialize(Bundle paramBundle)
  {
    this.extInfo = paramBundle.getString("_wxappextendobject_extInfo");
    this.fileData = paramBundle.getByteArray("_wxappextendobject_fileData");
    this.filePath = paramBundle.getString("_wxappextendobject_filePath");
  }

  public int type()
  {
    return 7;
  }

  public boolean checkArgs()
  {
    if (((this.extInfo == null) || (this.extInfo.length() == 0)) && ((this.filePath == null) || (this.filePath.length() == 0)) && ((this.fileData == null) || (this.fileData.length == 0)))
    {
      a.a("MicroMsg.SDK.WXAppExtendObject", "checkArgs fail, all arguments is null");
      return false;
    }
    if ((this.extInfo != null) && (this.extInfo.length() > 2048))
    {
      a.a("MicroMsg.SDK.WXAppExtendObject", "checkArgs fail, extInfo is invalid");
      return false;
    }
    if ((this.filePath != null) && (this.filePath.length() > 10240))
    {
      a.a("MicroMsg.SDK.WXAppExtendObject", "checkArgs fail, filePath is invalid");
      return false;
    }
    if ((this.filePath != null) && (getFileSize(this.filePath) > 10485760))
    {
      a.a("MicroMsg.SDK.WXAppExtendObject", "checkArgs fail, fileSize is too large");
      return false;
    }
    if ((this.fileData != null) && (this.fileData.length > 10485760))
    {
      a.a("MicroMsg.SDK.WXAppExtendObject", "checkArgs fail, fileData is too large");
      return false;
    }
    return true;
  }

  private int getFileSize(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return 0;
    if (!(paramString = new File(paramString)).exists())
      return 0;
    return (int)paramString.length();
  }
}

/* Location:           /Users/wayliu/git/wechat-sdk-sample/amm_sdk_sample/libs/libammsdk 2.jar
 * Qualified Name:     com.tencent.mm.sdk.modelmsg.WXAppExtendObject
 * JD-Core Version:    0.6.2
 */