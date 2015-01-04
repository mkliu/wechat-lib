package com.tencent.mm.a;

import java.security.MessageDigest;

public final class a
{
  public static final String a(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar1 = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    try
    {
      MessageDigest localMessageDigest;
      (localMessageDigest = MessageDigest.getInstance("MD5")).update(paramArrayOfByte);
      int i;
      char[] arrayOfChar2 = new char[(i = (paramArrayOfByte = localMessageDigest.digest()).length) * 2];
      int j = 0;
      for (int k = 0; k < i; k++)
      {
        int m = paramArrayOfByte[k];
        arrayOfChar2[(j++)] = arrayOfChar1[(m >>> 4 & 0xF)];
        arrayOfChar2[(j++)] = arrayOfChar1[(m & 0xF)];
      }
      return new String(arrayOfChar2);
    }
    catch (Exception localException)
    {
    }
    return null;
  }
}

/* Location:           /Users/wayliu/git/wechat-sdk-sample/amm_sdk_sample/libs/libammsdk 2.jar
 * Qualified Name:     com.tencent.mm.a.a
 * JD-Core Version:    0.6.2
 */