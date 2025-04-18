package wanted.logic.commands;

import static java.util.Objects.requireNonNull;

import wanted.model.LoanBook;
import wanted.model.Model;

/**
 * Clears the loan book.
 */
public class ClearCommand extends Command {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_SUCCESS = "Address book has been cleared!";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.setLoanBook(new LoanBook());
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
