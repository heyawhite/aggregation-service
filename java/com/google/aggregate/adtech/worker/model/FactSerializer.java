/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.aggregate.adtech.worker.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.google.aggregate.adtech.worker.util.NumericConversions;
import java.io.IOException;
import java.math.BigInteger;

/**
 * Serializes the {@link Fact} to the format Chrome produces which uses byte strings for 128-bit and
 * 32-bit unsigned integers
 */
public final class FactSerializer extends StdSerializer<Fact> {

  FactSerializer() {
    super(Fact.class);
  }

  @Override
  public void serialize(Fact fact, JsonGenerator jsonGenerator, SerializerProvider unused)
      throws IOException {
    // Convert bucket and value to bytes
    byte[] bucketBytes = NumericConversions.toUnSignedByteArray(fact.bucket());
    byte[] valueBytes = NumericConversions.toUnSignedByteArray(BigInteger.valueOf(fact.value()));

    jsonGenerator.writeStartObject();
    jsonGenerator.writeBinaryField("bucket", bucketBytes);
    jsonGenerator.writeBinaryField("value", valueBytes);
    jsonGenerator.writeEndObject();
  }
}
