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

import static com.google.aggregate.adtech.worker.model.ErrorCounter.ORIGINAL_REPORT_TIME_TOO_OLD;
import static java.time.temporal.ChronoUnit.DAYS;

import com.google.aggregate.adtech.worker.model.ErrorMessage;
import com.google.aggregate.adtech.worker.model.Report;
import com.google.inject.Inject;
import com.google.scp.operator.cpio.jobclient.model.Job;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.Optional;

/** Validates that the report is younger than the max age threshold. */
public final class ReportNotTooOldValidator implements ReportValidator {

  private static final Duration MAX_REPORT_AGE = Duration.of(90, DAYS);

  // Used for checking report age
  private final Clock clock;

  /** Constructor takes a clock that can be injected for testing */
  @Inject
  public ReportNotTooOldValidator(Clock clock) {
    this.clock = clock;
  }

  @Override
  public Optional<ErrorMessage> validate(Report report, Job unused) {
    Instant oldestAllowedTime = Instant.now(clock).minus(MAX_REPORT_AGE);
    if (report.sharedInfo().scheduledReportTime().isAfter(oldestAllowedTime)) {
      return Optional.empty();
    }

    return Optional.of(
        ErrorMessage.builder()
            .setCategory(ORIGINAL_REPORT_TIME_TOO_OLD.name())
            .setDetailedErrorMessage(
                detailedErrorMessage(oldestAllowedTime, report.sharedInfo().scheduledReportTime()))
            .build());
  }

  private String detailedErrorMessage(Instant oldestAllowedTime, Instant originalReportTime) {
    return String.format(
        "Report's originalReportTime is too old, reports cannot be older than %s, must be more"
            + " recent than %s but was %s",
        MAX_REPORT_AGE, oldestAllowedTime, originalReportTime);
  }
}
