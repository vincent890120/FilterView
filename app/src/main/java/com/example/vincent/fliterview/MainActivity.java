package com.example.vincent.fliterview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.vincent.filterview.entity.FilterData;
import com.example.vincent.filterview.entity.FilterEntity;
import com.example.vincent.filterview.entity.FilterTwoEntity;
import com.example.vincent.filterview.FilterView;

public class MainActivity extends AppCompatActivity {

    private FilterView filterView;
    private FilterData filterData; // 筛选数据

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filterView = (FilterView) findViewById(R.id.fv_top_filter);
        // 筛选数据
        filterData = new FilterData();
        filterData.setCategory(ModelUtil.getCategoryData());
        filterData.setSorts(ModelUtil.getSortData());
        filterData.setFilters(ModelUtil.getFilterData());

        filterView.setFilterData(this, filterData);

        // (真正的)筛选视图点击
        filterView.setOnFilterClickListener(new FilterView.OnFilterClickListener() {
            @Override
            public void onFilterClick(int position) {
                filterView.showFilterLayout(position);
            }
        });

        // 分类Item点击
        filterView.setOnItemCategoryClickListener(new FilterView.OnItemCategoryClickListener() {
            @Override
            public void onItemCategoryClick(FilterTwoEntity entity) {
                Log.d("vincent", entity.getSelectedFilterEntity().getKey());
            }
        });

        // 排序Item点击
        filterView.setOnItemSortClickListener(new FilterView.OnItemSortClickListener() {
            @Override
            public void onItemSortClick(FilterEntity entity) {
                Log.d("vincent", entity.getKey());

            }
        });

        // 筛选Item点击
        filterView.setOnItemFilterClickListener(new FilterView.OnItemFilterClickListener() {
            @Override
            public void onItemFilterClick(FilterEntity entity) {
                Log.d("vincent", entity.getKey());

            }
        });
    }
}
