package com.tencent.mm.sdk;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.database.Cursor;
import com.tencent.mm.sdk.c.a.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  implements SharedPreferences
{
  private final ContentResolver a;
  private final String[] b = { "_id", "key", "type", "value" };
  private final HashMap<String, Object> c = new HashMap();
  private a d = null;

  public a(Context paramContext)
  {
    this.a = paramContext.getContentResolver();
  }

  private Object getValue(String paramString)
  {
    try
    {
      if ((paramString = this.a.query(a.b.CONTENT_URI, this.b, "key = ?", new String[] { paramString }, null)) == null)
        return null;
      int i = paramString.getColumnIndex("type");
      int j = paramString.getColumnIndex("value");
      Object localObject = null;
      if (paramString.moveToFirst())
        localObject = com.tencent.mm.sdk.c.a.a.a(paramString.getInt(i), paramString.getString(j));
      paramString.close();
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }

  public final Map<String, ?> getAll()
  {
    try
    {
      Cursor localCursor;
      if ((localCursor = this.a.query(a.b.CONTENT_URI, this.b, null, null, null)) == null)
        return null;
      int i = localCursor.getColumnIndex("key");
      int j = localCursor.getColumnIndex("type");
      int k = localCursor.getColumnIndex("value");
      while (localCursor.moveToNext())
      {
        Object localObject = com.tencent.mm.sdk.c.a.a.a(localCursor.getInt(j), localCursor.getString(k));
        this.c.put(localCursor.getString(i), localObject);
      }
      localCursor.close();
      return this.c;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return this.c;
  }

  public final String getString(String paramString1, String paramString2)
  {
    if (((paramString1 = getValue(paramString1)) != null) && ((paramString1 instanceof String)))
      return (String)paramString1;
    return paramString2;
  }

  public final int getInt(String paramString, int paramInt)
  {
    if (((paramString = getValue(paramString)) != null) && ((paramString instanceof Integer)))
      return ((Integer)paramString).intValue();
    return paramInt;
  }

  public final long getLong(String paramString, long paramLong)
  {
    if (((paramString = getValue(paramString)) != null) && ((paramString instanceof Long)))
      return ((Long)paramString).longValue();
    return paramLong;
  }

  public final float getFloat(String paramString, float paramFloat)
  {
    if (((paramString = getValue(paramString)) != null) && ((paramString instanceof Float)))
      return ((Float)paramString).floatValue();
    return paramFloat;
  }

  public final boolean getBoolean(String paramString, boolean paramBoolean)
  {
    if (((paramString = getValue(paramString)) != null) && ((paramString instanceof Boolean)))
      return ((Boolean)paramString).booleanValue();
    return paramBoolean;
  }

  public final boolean contains(String paramString)
  {
    return getValue(paramString) != null;
  }

  public final SharedPreferences.Editor edit()
  {
    if (this.d == null)
      this.d = new a(this.a);
    return this.d;
  }

  public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
  }

  public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
  }

  public final Set<String> getStringSet(String paramString, Set<String> paramSet)
  {
    return null;
  }

  private static class a
    implements SharedPreferences.Editor
  {
    private Map<String, Object> e = new HashMap();
    private Set<String> f = new HashSet();
    private boolean g = false;
    private ContentResolver a;

    public a(ContentResolver paramContentResolver)
    {
      this.a = paramContentResolver;
    }

    public final SharedPreferences.Editor putString(String paramString1, String paramString2)
    {
      this.e.put(paramString1, paramString2);
      this.f.remove(paramString1);
      return this;
    }

    public final SharedPreferences.Editor putInt(String paramString, int paramInt)
    {
      this.e.put(paramString, Integer.valueOf(paramInt));
      this.f.remove(paramString);
      return this;
    }

    public final SharedPreferences.Editor putLong(String paramString, long paramLong)
    {
      this.e.put(paramString, Long.valueOf(paramLong));
      this.f.remove(paramString);
      return this;
    }

    public final SharedPreferences.Editor putFloat(String paramString, float paramFloat)
    {
      this.e.put(paramString, Float.valueOf(paramFloat));
      this.f.remove(paramString);
      return this;
    }

    public final SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
    {
      this.e.put(paramString, Boolean.valueOf(paramBoolean));
      this.f.remove(paramString);
      return this;
    }

    public final SharedPreferences.Editor remove(String paramString)
    {
      this.f.add(paramString);
      return this;
    }

    public final SharedPreferences.Editor clear()
    {
      this.g = true;
      return this;
    }

    public final boolean commit()
    {
      ContentValues localContentValues1 = new ContentValues();
      if (this.g)
      {
        this.a.delete(a.b.CONTENT_URI, null, null);
        this.g = false;
      }
      Object localObject1 = this.f.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        this.a.delete(a.b.CONTENT_URI, "key = ?", new String[] { localObject2 });
      }
      Object localObject2 = this.e.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (Map.Entry)((Iterator)localObject2).next();
        Object localObject3 = ((Map.Entry)localObject1).getValue();
        ContentValues localContentValues2 = localContentValues1;
        Object localObject4;
        com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, null value");
        com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, unknown type=" + localObject4.getClass().toString());
        int i;
        localContentValues2.put("type", Integer.valueOf(i));
        localContentValues2.put("value", localObject3.toString());
        if (((i = (localObject4 instanceof Double) ? 6 : (localObject4 instanceof Float) ? 5 : (localObject4 instanceof Boolean) ? 4 : (localObject4 instanceof String) ? 3 : (localObject4 instanceof Long) ? 2 : (localObject4 instanceof Integer) ? 1 : (localObject4 = localObject3) == null ? 0 : 0) == 0 ? 0 : 1) != 0)
          this.a.update(a.b.CONTENT_URI, localContentValues1, "key = ?", new String[] { (String)((Map.Entry)localObject1).getKey() });
      }
      return true;
    }

    public final void apply()
    {
    }

    public final SharedPreferences.Editor putStringSet(String paramString, Set<String> paramSet)
    {
      return null;
    }
  }
}

/* Location:           /Users/wayliu/git/wechat-sdk-sample/amm_sdk_sample/libs/libammsdk 2.jar
 * Qualified Name:     com.tencent.mm.sdk.a
 * JD-Core Version:    0.6.2
 */