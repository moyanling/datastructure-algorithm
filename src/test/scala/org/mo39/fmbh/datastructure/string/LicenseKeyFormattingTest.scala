package org.mo39.fmbh.datastructure.string

import org.mo39.fmbh.commons.MoTestSuite

class LicenseKeyFormattingTest extends MoTestSuite[LicenseKeyFormatting] {

  g("5F3Z-2e-9-w, 4") { solution =>
    assert(solution.licenseKeyFormatting("5F3Z-2e-9-w", 4) === "5F3Z-2E9W")
  }

  g("2-5g-3-J, 2") { solution =>
    assert(solution.licenseKeyFormatting("2-5g-3-J", 2) === "2-5G-3J")
  }

}
