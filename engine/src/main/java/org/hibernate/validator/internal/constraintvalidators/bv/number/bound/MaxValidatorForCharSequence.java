/*
 * Hibernate Validator, declare and validate application constraints
 *
 * License: Apache License, Version 2.0
 * See the license.txt file in the root directory or <http://www.apache.org/licenses/LICENSE-2.0>.
 */
package org.hibernate.validator.internal.constraintvalidators.bv.number.bound;

import java.math.BigDecimal;

/**
 * Check that the character sequence (e.g. string) validated represents a number, and has a value less than or equal to
 * the maximum value specified.
 *
 * @author Alaa Nassef
 * @author Kevin Pollet &lt;kevin.pollet@serli.com&gt; (C) 2011 SERLI
 * @author Guillaume Smet
 */
public class MaxValidatorForCharSequence extends AbstractMaxValidator<CharSequence> {

	@Override
	protected int compare(CharSequence number) {
		try {
			return NumberComparatorHelper.compare( new BigDecimal( number.toString() ), maxValue );
		}
		catch (NumberFormatException nfe) {
			return 1;
		}
	}
}
