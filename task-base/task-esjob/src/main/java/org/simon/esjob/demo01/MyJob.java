package org.simon.esjob.demo01;

import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.simple.job.SimpleJob;

import lombok.extern.slf4j.Slf4j;

/**
 * 你搞忘写注释了
 *
 * @author zhang_zhang
 * @date 2020-12-21
 * @since 1.0.0
 */
@Slf4j
public class MyJob implements SimpleJob {

    @Override
    public void execute(ShardingContext context) {
        log.info("------------>sharding:{}, totalCount:{}", context.getShardingItem(), context.getShardingTotalCount());
    }
}