package com.tencent.mm.sdk.modelmsg;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class WXImageObject
  implements WXMediaMessage.IMediaObject
{
  private static final String TAG = "MicroMsg.SDK.WXImageObject";
  private static final int CONTENT_LENGTH_LIMIT = 10485760;
  private static final int PATH_LENGTH_LIMIT = 10240;
  private static final int URL_LENGTH_LIMIT = 10240;
  public byte[] imageData;
  public String imagePath;
  public String imageUrl;

  public WXImageObject()
  {
  }

  public WXImageObject(byte[] paramArrayOfByte)
  {
    this.imageData = paramArrayOfByte;
  }

  public WXImageObject(Bitmap paramBitmap)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 85, localByteArrayOutputStream);
      this.imageData = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public void setImagePath(String paramString)
  {
    this.imagePath = paramString;
  }

  public void serialize(Bundle paramBundle)
  {
    paramBundle.putByteArray("_wximageobject_imageData", this.imageData);
    paramBundle.putString("_wximageobject_imagePath", this.imagePath);
    paramBundle.putString("_wximageobject_imageUrl", this.imageUrl);
  }

  public void unserialize(Bundle paramBundle)
  {
    this.imageData = paramBundle.getByteArray("_wximageobject_imageData");
    this.imagePath = paramBundle.getString("_wximageobject_imagePath");
    this.imageUrl = paramBundle.getString("_wximageobject_imageUrl");
  }

  public int type()
  {
    return 2;
  }

  public boolean checkArgs()
  {
    if (((this.imageData == null) || (this.imageData.length == 0)) && ((this.imagePath == null) || (this.imagePath.length() == 0)) && ((this.imageUrl == null) || (this.imageUrl.length() == 0)))
    {
      a.a("MicroMsg.SDK.WXImageObject", "checkArgs fail, all arguments are null");
      return false;
    }
    if ((this.imageData != null) && (this.imageData.length > 10485760))
    {
      a.a("MicroMsg.SDK.WXImageObject", "checkArgs fail, content is too large");
      return false;
    }
    if ((this.imagePath != null) && (this.imagePath.length() > 10240))
    {
      a.a("MicroMsg.SDK.WXImageObject", "checkArgs fail, path is invalid");
      return false;
    }
    if ((this.imagePath != null) && (getFileSize(this.imagePath) > 10485760))
    {
      a.a("MicroMsg.SDK.WXImageObject", "checkArgs fail, image content is too large");
      return false;
    }
    if ((this.imageUrl != null) && (this.imageUrl.length() > 10240))
    {
      a.a("MicroMsg.SDK.WXImageObject", "checkArgs fail, url is invalid");
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
 * Qualified Name:     com.tencent.mm.sdk.modelmsg.WXImageObject
 * JD-Core Version:    0.6.2
 */