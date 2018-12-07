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

interface DataMapper<SOURCE, DESTINATION> {
    fun transform(data: SOURCE): DESTINATION
}

class PersonMapper(
    private val salaryMapper: DataMapper<SalarySrc, SalaryDst>
) : DataMapper<PersonSrc, PersonDst> {
    override fun transform(src: PersonSrc) = PersonDst(
        src.name,
        salaryMapper.transform(src.salary)
    )
}

class SalaryMapper : DataMapper<SalarySrc, SalaryDst> {
    override fun transform(src: SalarySrc) = SalaryDst(src.amount)
}
