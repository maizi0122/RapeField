/*
 * $HomePage: https://github.com/maizi0122/ $
 * $Revision: 000001 $
 * $Date: 2015-10-18 09:05:31 -0000 (Sun, 18 Oct 2015) $
 *
 * ====================================================================
 * Copyright (C) 2015 The Maizi-Studio Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This project powered by Maizi-Studio, but works with the
 * license of apache,so you should abide by this license.
 * Any question contacting with email below:
 * maizi0122@gmail.com
 */

package org.studio.maizi.viewinjection;

import android.app.Activity;
import android.app.Fragment;
import android.view.View;
import android.widget.Adapter;

/**
 * the interface of auto view injection<br />
 * Powered by Maizi-Studio.<br />
 * Design by maizi.<br />
 * Created on 15-10-30.
 */
public interface IViewInjection {
    /**
     * init views automatic in an activity.
     *
     * @param context  current context which relate to an instance of window
     * @param listener additional params, when your class of listener have no empty-parameter constructor, you should pass the listener object manually...
     * @return current obj
     */
    IViewInjection initView(Activity context, Object... listener);

    /**
     * init views automatic in an fragment.
     *
     * @param fragment the fragment object.
     * @param root     the root view in your fragment.
     * @param listener additional params, when your class of listener have no empty-parameter constructor, you should pass the listener object manually...
     * @return current obj
     */
    IViewInjection initView(Fragment fragment, View root, Object... listener);

    /**
     * init views automatic in a adapter.
     *
     * @param adapter   this impl class of adapter.
     * @param root      the root view of current item.
     * @param holder    the holder object of your adapter view.
     * @param listeners additional params, when your class of listener have no empty-parameter constructor, you should pass the listener object manually...
     * @return current obj
     */
    IViewInjection initView(Adapter adapter, View root, Object holder, Object... listeners);

    /**
     * specify the object of listener binding
     *
     * @param eventBinder the object of listener binding
     */
    IViewInjection setEventBinder(IEventBinder eventBinder);
}
