// **********************************************************************
//
// Copyright (c) 2003-2013 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.5.1
//
// <auto-generated>
//
// Generated from file `client.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package clientOperations;

public interface AccountPrx extends Ice.ObjectPrx
{
    public String getAccountInfo();

    public String getAccountInfo(java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_getAccountInfo();

    public Ice.AsyncResult begin_getAccountInfo(java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_getAccountInfo(Ice.Callback __cb);

    public Ice.AsyncResult begin_getAccountInfo(java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_getAccountInfo(Callback_Account_getAccountInfo __cb);

    public Ice.AsyncResult begin_getAccountInfo(java.util.Map<String, String> __ctx, Callback_Account_getAccountInfo __cb);

    public String end_getAccountInfo(Ice.AsyncResult __result);

    public boolean isPremiumAccount(String PESEL);

    public boolean isPremiumAccount(String PESEL, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_isPremiumAccount(String PESEL);

    public Ice.AsyncResult begin_isPremiumAccount(String PESEL, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_isPremiumAccount(String PESEL, Ice.Callback __cb);

    public Ice.AsyncResult begin_isPremiumAccount(String PESEL, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_isPremiumAccount(String PESEL, Callback_Account_isPremiumAccount __cb);

    public Ice.AsyncResult begin_isPremiumAccount(String PESEL, java.util.Map<String, String> __ctx, Callback_Account_isPremiumAccount __cb);

    public boolean end_isPremiumAccount(Ice.AsyncResult __result);

    public String getAccessKey();

    public String getAccessKey(java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_getAccessKey();

    public Ice.AsyncResult begin_getAccessKey(java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_getAccessKey(Ice.Callback __cb);

    public Ice.AsyncResult begin_getAccessKey(java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_getAccessKey(Callback_Account_getAccessKey __cb);

    public Ice.AsyncResult begin_getAccessKey(java.util.Map<String, String> __ctx, Callback_Account_getAccessKey __cb);

    public String end_getAccessKey(Ice.AsyncResult __result);
}
