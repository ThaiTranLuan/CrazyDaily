/**
 * Copyright 2017 Sun Jian
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.crazysunj.data.repository.gankio;

import com.crazysunj.data.api.HttpHelper;
import com.crazysunj.data.service.GankioService;
import com.crazysunj.data.util.RxTransformerUtil;
import com.crazysunj.domain.entity.GankioEntity;
import com.crazysunj.domain.repository.gankio.GankioRepository;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * author: sunjian
 * created on: 2017/9/19 下午6:58
 * description: https://github.com/crazysunj/CrazyDaily
 */

public class GankioDataRepository implements GankioRepository {

    private GankioService mGankioService;

    @Inject
    public GankioDataRepository(HttpHelper httpHelper) {
        mGankioService = httpHelper.getGankioService();
    }

    @Override
    public Flowable<GankioEntity> getGankio(String type) {
        return mGankioService.getGankio(type)
                .compose(RxTransformerUtil.normalTransformer());
    }
}
