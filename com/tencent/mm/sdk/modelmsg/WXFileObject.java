package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import java.io.File;

public class WXFileObject
  implements WXMediaMessage.IMediaObject
{
  private static final String TAG = "MicroMsg.SDK.WXFileObject";
  private static final int CONTENT_LENGTH_LIMIT = 10485760;
  private int contentLengthLimit = 10485760;
  public byte[] fileData;
  public String filePath;

  public WXFileObject()
  {
    this.fileData = null;
    this.filePath = null;
  }

  public WXFileObject(byte[] paramArrayOfByte)
  {
    this.fileData = paramArrayOfByte;
  }

  public WXFileObject(String paramString)
  {
    this.filePath = paramString;
  }

  public void setFileData(byte[] paramArrayOfByte)
  {
    this.fileData = paramArrayOfByte;
  }

  public void setFilePath(String paramString)
  {
    this.filePath = paramString;
  }

  public void serialize(Bundle paramBundle)
  {
    paramBundle.putByteArray("_wxfileobject_fileData", this.fileData);
    paramBundle.putString("_wxfileobject_filePath", this.filePath);
  }

  public void unserialize(Bundle paramBundle)
  {
    this.fileData = paramBundle.getByteArray("_wxfileobject_fileData");
    this.filePath = paramBundle.getString("_wxfileobject_filePath");
  }

  public int type()
  {
    return 6;
  }

  public void setContentLengthLimit(int paramInt)
  {
    this.contentLengthLimit = paramInt;
  }

  public boolean checkArgs()
  {
    if (((this.fileData == null) || (this.fileData.length == 0)) && ((this.filePath == null) || (this.filePath.length() == 0)))
    {
      a.a("MicroMsg.SDK.WXFileObject", "checkArgs fail, both arguments is null");
      return false;
    }
    if ((this.fileData != null) && (this.fileData.length > this.contentLengthLimit))
    {
      a.a("MicroMsg.SDK.WXFileObject", "checkArgs fail, fileData is too large");
      return false;
    }
    if ((this.filePath != null) && (getFileSize(this.filePath) > this.contentLengthLimit))
    {
      a.a("MicroMsg.SDK.WXFileObject", "checkArgs fail, fileSize is too large");
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
 * Qualified Name:     com.tencent.mm.sdk.modelmsg.WXFileObject
 * JD-Core Version:    0.6.2
 */