/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.pulsar.functions.api.examples.window;

import java.util.Collection;
import java.util.Optional;
import org.apache.pulsar.functions.api.Record;
import org.apache.pulsar.functions.api.WindowContext;
import org.apache.pulsar.functions.api.WindowFunction;

/**
 * An example demonstrate retrieving user config value from Context.
 */
public class UserConfigWindowFunction implements WindowFunction<String, String> {
    @Override
    public String process(Collection<Record<String>> input, WindowContext context) throws Exception {
        Optional<Object> whatToWrite = context.getUserConfigValue("WhatToWrite");
        if (whatToWrite.get() != null) {
            return (String)whatToWrite.get();
        } else {
            return "Not a nice way";
        }
    }
}
