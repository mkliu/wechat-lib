package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import java.io.File;

public class WXEmojiObject
  implements WXMediaMessage.IMediaObject
{
  private static final String TAG = "MicroMsg.SDK.WXEmojiObject";
  private static final int CONTENT_LENGTH_LIMIT = 10485760;
  public byte[] emojiData;
  public String emojiPath;

  public WXEmojiObject()
  {
    this.emojiData = null;
    this.emojiPath = null;
  }

  public WXEmojiObject(byte[] paramArrayOfByte)
  {
    this.emojiData = paramArrayOfByte;
  }

  public WXEmojiObject(String paramString)
  {
    this.emojiPath = paramString;
  }

  public void setEmojiData(byte[] paramArrayOfByte)
  {
    this.emojiData = paramArrayOfByte;
  }

  public void setEmojiPath(String paramString)
  {
    this.emojiPath = paramString;
  }

  public void serialize(Bundle paramBundle)
  {
    paramBundle.putByteArray("_wxemojiobject_emojiData", this.emojiData);
    paramBundle.putString("_wxemojiobject_emojiPath", this.emojiPath);
  }

  public void unserialize(Bundle paramBundle)
  {
    this.emojiData = paramBundle.getByteArray("_wxemojiobject_emojiData");
    this.emojiPath = paramBundle.getString("_wxemojiobject_emojiPath");
  }

  public int type()
  {
    return 8;
  }

  public boolean checkArgs()
  {
    if (((this.emojiData == null) || (this.emojiData.length == 0)) && ((this.emojiPath == null) || (this.emojiPath.length() == 0)))
    {
      a.a("MicroMsg.SDK.WXEmojiObject", "checkArgs fail, both arguments is null");
      return false;
    }
    if ((this.emojiData != null) && (this.emojiData.length > 10485760))
    {
      a.a("MicroMsg.SDK.WXEmojiObject", "checkArgs fail, emojiData is too large");
      return false;
    }
    if ((this.emojiPath != null) && (getFileSize(this.emojiPath) > 10485760))
    {
      a.a("MicroMsg.SDK.WXEmojiObject", "checkArgs fail, emojiSize is too large");
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
 * Qualified Name:     com.tencent.mm.sdk.modelmsg.WXEmojiObject
 * JD-Core Version:    0.6.2
 */