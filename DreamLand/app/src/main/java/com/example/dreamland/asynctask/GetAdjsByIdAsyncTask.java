package com.example.dreamland.asynctask;

import android.os.AsyncTask;
import android.util.Log;

import com.example.dreamland.PosDetailAdapter;
import com.example.dreamland.database.Adjustment;
import com.example.dreamland.database.AdjustmentDao;

import java.util.List;

public class GetAdjsByIdAsyncTask extends AsyncTask<Adjustment, Void, List<Adjustment>> {

    private AdjustmentDao AdjustmentDao;
    private String id;

    public GetAdjsByIdAsyncTask(AdjustmentDao AdjustmentDao, String id) {
        this.AdjustmentDao = AdjustmentDao;
        this.id = id;
    }

    @Override
    protected List<Adjustment> doInBackground(Adjustment... Adjustments) {
        return AdjustmentDao.getAdjsById(id);
    }
}
