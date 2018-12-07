// ==== data ====

class PersonSrc(
    val name: String,
    val salary: SalarySrc
)
class SalarySrc(val amount: Int)

class PersonDst(
    val name: String,
    val salary: SalaryDst
)
class SalaryDst(val amount: Int)

// ==== mappers ====

fun mapPerson(
    src: PersonSrc,
    salaryMapper: (SalarySrc) -> SalaryDst
) = PersonDst(
    src.name,
    salaryMapper.invoke(src.salary)
)

fun mapSalary(src: SalarySrc) = SalaryDst(src.amount)

// ==== usages ====

val personSrc = PersonSrc("Oleg", SalarySrc(10))
val personDst = mapPerson(personSrc, ::mapSalary)
