
/**
 * Src classes - Source layer classes
 * Dst classes - Destination layer classes
 *
 * Layer Source depends Destination layer.
 * Layer Destination does NOT depend Source layer.
 */

/**
 * Dependent layer class
 *
 * Can be created from Destination layer class
 * Can create Destination layer class
 */
class PersonSrc private constructor(
    private val name: String,
    private val salary: SalarySrc
) {
    companion object {
        /**
         * Mapping from destination
         */
        operator fun invoke(dst: PersonDst): PersonSrc {
            return PersonSrc(dst.name, SalarySrc(dst.salary))
        }
    }

    /**
     * Mapping to destination
     */
    fun mapToDestination() = PersonDst(
        name,
        salary.mapToDestination()
    )
}


/**
 * Dependent layer class
 *
 * Can be created from Destination layer class
 * Can create Destination layer class
 */
class SalarySrc private constructor(
    private val amount: Int
) {
    companion object {
        /**
         * Mapping from destination
         */
        operator fun invoke(dst: SalaryDst): SalarySrc {
            return SalarySrc(dst.amount)
        }
    }

    /**
     * Mapping to destination
     */
    fun mapToDestination() = SalaryDst(amount)
}

/**
 * Independent layer class
 */
class PersonDst(
    val name: String,
    val salary: SalaryDst
)

/**
 * Independent layer class
 */
class SalaryDst(val amount: Int)


// ==== usages ====

val personDst = PersonDst("Oleg", SalaryDst((10)))

val personSrc = PersonSrc(personDst)

val mappedPersonDst = personSrc.mapToDestination()
