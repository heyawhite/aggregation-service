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

package com.google.aggregate.adtech.worker.validation;

import com.google.aggregate.adtech.worker.model.ErrorMessage;
import com.google.aggregate.adtech.worker.model.Payload;
import com.google.aggregate.adtech.worker.model.Report;
import com.google.common.collect.ImmutableSet;
import com.google.scp.operator.cpio.jobclient.model.Job;
import com.google.scp.operator.protos.shared.backend.JobErrorCategoryProto.JobErrorCategory;
import java.util.Optional;

/** Validates that the report's operation is an accepted value */
public final class SupportedOperationValidator implements ReportValidator {

  // Only the "histogram" operation is supported
  private static final ImmutableSet<String> SUPPORTED_OPERATIONS =
      ImmutableSet.of(Payload.HISTOGRAM_OPERATION);
  private static final String DETAILED_ERROR_MESSAGE_TEMPLATE =
      "Report's operation is not supported. Operation was '%s'. Supported operations are %s.";

  @Override
  public Optional<ErrorMessage> validate(Report report, Job unused) {
    if (SUPPORTED_OPERATIONS.contains(report.payload().operation())) {
      return Optional.empty();
    }
    return Optional.of(
        ErrorMessage.builder()
            .setCategory(JobErrorCategory.UNSUPPORTED_OPERATION.name())
            .setDetailedErrorMessage(
                String.format(
                    DETAILED_ERROR_MESSAGE_TEMPLATE,
                    report.payload().operation(),
                    SUPPORTED_OPERATIONS))
            .build());
  }
}
