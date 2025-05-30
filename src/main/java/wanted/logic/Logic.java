package wanted.logic;

import java.nio.file.Path;

import javafx.collections.ObservableList;
import wanted.commons.core.GuiSettings;
import wanted.logic.commands.CommandResult;
import wanted.logic.commands.exceptions.CommandException;
import wanted.logic.parser.exceptions.ParseException;
import wanted.model.Model;
import wanted.model.ReadOnlyLoanBook;
import wanted.model.loan.Loan;

/**
 * API of the Logic component
 */
public interface Logic {
    /**
     * Executes the command and returns the result.
     * @param commandText The command as entered by the user.
     * @return the result of the command execution.
     * @throws CommandException If an error occurs during command execution.
     * @throws ParseException If an error occurs during parsing.
     */
    CommandResult execute(String commandText) throws CommandException, ParseException;

    /**
     * Returns the LoanBook.
     *
     * @see Model#getLoanBook()
     */
    ReadOnlyLoanBook getLoanBook();

    /** Returns an unmodifiable view of the filtered list of persons */
    ObservableList<Loan> getFilteredPersonList();

    /**
     * Returns the user prefs' loan book file path.
     */
    Path getLoanBookFilePath();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Set the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);
}
