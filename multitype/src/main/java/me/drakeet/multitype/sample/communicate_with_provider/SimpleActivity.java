/*
 * Copyright 2016 drakeet. https://github.com/drakeet
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.drakeet.multitype.sample.communicate_with_provider;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;
import me.drakeet.multitype.sample.MenuBaseActivity;
import me.drakeet.multitype.sample.R;
import me.drakeet.multitype.sample.normal.item.TextItem;

import static java.lang.String.valueOf;
import static me.drakeet.multitype.MultiTypeAsserts.assertAllRegistered;
import static me.drakeet.multitype.MultiTypeAsserts.assertHasTheSameAdapter;

/**
 * @author drakeet，好像可以忽略，一个可用可不用的代码
 */
public class SimpleActivity extends MenuBaseActivity {

    private String aFieldValue = "aFieldValue of SimpleActivity";
    private Items items;
    private MultiTypeAdapter adapter;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);

        items = new Items();
        adapter = new MultiTypeAdapter(items);
        adapter.register(TextItem.class, new TextItemWithOutsizeDataViewProvider(aFieldValue));

        for (int i = 0; i < 20; i++) {
            items.add(new TextItem(valueOf(i)));
        }

        assertAllRegistered(adapter, items);
        recyclerView.setAdapter(adapter);
        assertHasTheSameAdapter(recyclerView, adapter);
    }
}
