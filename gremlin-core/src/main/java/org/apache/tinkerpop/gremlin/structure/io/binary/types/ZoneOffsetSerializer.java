/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.tinkerpop.gremlin.structure.io.binary.types;

import org.apache.tinkerpop.gremlin.structure.io.binary.DataType;
import org.apache.tinkerpop.gremlin.structure.io.binary.GraphBinaryReader;
import org.apache.tinkerpop.gremlin.structure.io.binary.GraphBinaryWriter;
import org.apache.tinkerpop.gremlin.structure.io.Buffer;

import java.io.IOException;
import java.time.ZoneOffset;

/**
 * @author Stephen Mallette (http://stephen.genoprime.com)
 */
public class ZoneOffsetSerializer extends SimpleTypeSerializer<ZoneOffset> {

    public ZoneOffsetSerializer() {
        super(DataType.ZONEOFFSET);
    }

    @Override
    protected ZoneOffset readValue(final Buffer buffer, final GraphBinaryReader context) throws IOException {
        return ZoneOffset.ofTotalSeconds(buffer.readInt());
    }

    @Override
    protected void writeValue(final ZoneOffset value, final Buffer buffer, final GraphBinaryWriter context) throws IOException {
        buffer.writeInt(value.getTotalSeconds());
    }
}
