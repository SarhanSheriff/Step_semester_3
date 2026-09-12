package inheritance.assignment_problems;

public class LoanReceipt {
    private final String memberId;
    private final String[] bookIds;

    public LoanReceipt(String memberId, String[] bookIds) {
        if (memberId == null || bookIds == null) throw new IllegalArgumentException();
        for (String id : bookIds) {
            if (id == null || id.length() != 6 || !id.startsWith("BK-")
                    || !Character.isDigit(id.charAt(3))
                    || !Character.isDigit(id.charAt(4))
                    || !Character.isDigit(id.charAt(5)))
                throw new IllegalArgumentException();
        }
        this.memberId = memberId;
        this.bookIds = bookIds.clone();
    }

    public String getMemberId() { return memberId; }
    public String[] getBookIds() { return bookIds.clone(); }

    public LoanReceipt withCorrectedBookId(int index, String newId) {
        String[] copy = getBookIds();
        if (index < 0 || index >= copy.length) throw new IndexOutOfBoundsException();
        copy[index] = newId;
        return new LoanReceipt(memberId, copy);
    }
}
