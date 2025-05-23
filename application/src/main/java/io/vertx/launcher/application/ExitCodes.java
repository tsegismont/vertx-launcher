/*
 * Copyright (c) 2011-2023 Contributors to the Eclipse Foundation
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0, or the Apache License, Version 2.0
 * which is available at https://www.apache.org/licenses/LICENSE-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0 OR Apache-2.0
 */

package io.vertx.launcher.application;

public class ExitCodes {

  public static final int SOFTWARE = 1;
  public static final int USAGE = 2;
  public static final int VERTX_INITIALIZATION = 11;
  public static final int VERTX_DEPLOYMENT = 15;

  private ExitCodes() {
    // Constants
  }
}
