/*
 *  $HomePage: https://github.com/maizi0122/ $
 *  $Revision: 000001 $
 *  $Date: 2015-10-18 09:05:31 -0000 (Sun, 18 Oct 2015) $
 *
 *  ====================================================================
 *  Copyright (C) 2015 The Maizi-Studio Open Source Project
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *  ====================================================================
 *
 *  This project powered by Maizi-Studio, but works with the
 *  license of apache,so you should abide by this license.
 *  Any question contacting with email below:
 *  maizi0122@gmail.com
 */

package org.studio.maizi.viewinjectiondemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.studio.maizi.viewinjection.IViewInjection;
import org.studio.maizi.viewinjection.anno.Adapter;
import org.studio.maizi.viewinjection.anno.ContentView;
import org.studio.maizi.viewinjection.anno.EventTarget;
import org.studio.maizi.viewinjection.anno.RegistListener;
import org.studio.maizi.viewinjection.anno.ResId;
import org.studio.maizi.viewinjection.impl.EventBinder;
import org.studio.maizi.viewinjection.impl.ViewInjection;

import java.util.ArrayList;
import java.util.List;

/**
 * Powered by Maizi-Studio.<br />
 * Design by maizi.<br />
 * Created on 15-11-5.
 */
@ContentView(R.layout.activity_sec)
@SuppressWarnings("all")
public class AdapterViewActivity3 extends Activity implements AdapterView.OnItemClickListener {

    private List<String> list = new ArrayList<String>() {
        {
            for (int i = 0; i < 20; i++) {
                this.add("(<-press img)...hello maizi...(<-long press tv)" + i);
            }
        }
    };

    @ResId(R.id.ac_sec_lv)
    @Adapter(CustomAdapter.class)
    @RegistListener(listeners = {AdapterViewActivity3.class})
    private ListView ac_sec_lv;

    private IViewInjection viewInjection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //you adapter class have no empty-params constructor,you should make instance manually and pass it like : initView(this, new MyAdapter("maizi"));
        viewInjection = new ViewInjection().initView(this, new CustomAdapter(list));

    }

    @Override
    @EventTarget(targets = {R.id.ac_sec_lv})
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String[] arrays = TextView.class.cast(view.findViewById(R.id.ac_sec_lv_item_tv)).getText().toString().split("\\(<\\-([a-z[\\p{Space}]]+)\\)");
        Toast.makeText(this, new StringBuilder("item ").append(arrays[1]).append(arrays[2]).append("\n have been clicked").toString(), Toast.LENGTH_SHORT).show();
    }

}