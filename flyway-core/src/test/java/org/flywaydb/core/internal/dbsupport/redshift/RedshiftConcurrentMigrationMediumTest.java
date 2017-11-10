/*
 * Copyright 2010-2017 Boxfuse GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.flywaydb.core.internal.dbsupport.redshift;

import org.flywaydb.core.DbCategory;
import org.flywaydb.core.internal.util.jdbc.DriverDataSource;
import org.flywaydb.core.migration.ConcurrentMigrationTestCase;
import org.junit.Before;
import org.junit.experimental.categories.Category;

import javax.sql.DataSource;
import java.util.Properties;

import static org.flywaydb.core.internal.dbsupport.redshift.RedshiftMigrationMediumTest.*;
import static org.junit.Assume.assumeTrue;

/**
 * Test to demonstrate the migration functionality using PostgreSQL.
 */
@Category(DbCategory.Redshift.class)
public class RedshiftConcurrentMigrationMediumTest extends ConcurrentMigrationTestCase {
    @Before
    public void ensureRedshiftEnabled() {
        assumeTrue(Boolean.valueOf(System.getProperty("redshift")));
    }

    @Override
    protected DataSource createDataSource(Properties customProperties) {
        return new DriverDataSource(Thread.currentThread().getContextClassLoader(), null,
                JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
}