/**
 * Copyright 2010 Philippe Beaudoin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.puzzlebazar.shared.action;

import com.philbeaudoin.gwtp.dispatch.shared.Action;

public class GetPuzzleAction implements Action< GetPuzzleResult > {

  private static final long serialVersionUID = 980090205056921146L;

  private long id;

  @SuppressWarnings("unused")
  private GetPuzzleAction() {
    // For serialization only
  }

  public GetPuzzleAction( long id ) {
    this.id = id;
  }

  public long getId() {
    return id;
  }
}