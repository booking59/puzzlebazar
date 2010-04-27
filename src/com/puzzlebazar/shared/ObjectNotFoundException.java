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

package com.puzzlebazar.shared;

import com.philbeaudoin.gwtp.dispatch.shared.ActionException;

public class ObjectNotFoundException extends ActionException {
  private static final long serialVersionUID = 1746815389319262484L;
  public ObjectNotFoundException() {
    super();
  }
  public ObjectNotFoundException(String string) {
    super(string);
  }

}