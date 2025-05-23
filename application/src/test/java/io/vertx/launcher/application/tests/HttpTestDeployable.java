/*
 * Copyright (c) 2011-2025 Contributors to the Eclipse Foundation
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0, or the Apache License, Version 2.0
 * which is available at https://www.apache.org/licenses/LICENSE-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0 OR Apache-2.0
 */

package io.vertx.launcher.application.tests;

import io.vertx.core.Context;
import io.vertx.core.Deployable;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

public class HttpTestDeployable implements Deployable {
  @Override
  public Future<?> deploy(Context context) throws Exception {
    long time = System.nanoTime();
    Vertx vertx = context.owner();
    return vertx.createHttpServer().requestHandler(request -> {
      JsonObject json = new JsonObject();
      json
        .put("threadingModel", context.threadingModel())
        .put("clustered", vertx.isClustered())
        .put("metrics", vertx.isMetricsEnabled())
        .put("id", System.getProperty("vertx.id", "no id"))
        .put("conf", context.config())
        .put("startTime", time);

      if (System.getProperty("foo") != null) {
        json.put("foo", System.getProperty("foo"));
      }

      if (System.getProperty("baz") != null) {
        json.put("baz", System.getProperty("baz"));
      }

      request.response().putHeader("content-type", "application/json").end(json.encodePrettily());
    }).listen(8080);
  }
}
