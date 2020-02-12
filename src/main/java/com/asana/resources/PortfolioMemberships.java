package com.asana.resources;

import com.asana.Client;
import com.asana.models.PortfolioMembership;
import com.asana.requests.CollectionRequest;
import com.asana.requests.ItemRequest;
import com.asana.resources.gen.PortfolioMembershipsBase;

public class PortfolioMemberships extends PortfolioMembershipsBase {
    public PortfolioMemberships(Client client) {
        super(client);
    }

    /**
     * Returns the compact portfolio membership records for the portfolio. You must
     * specify `portfolio`, `portfolio` and `user`, or `workspace` and `user`.
     *
     * @return Request object
     */
    public CollectionRequest<PortfolioMembership> findAll() {

        return new CollectionRequest<PortfolioMembership>(this, PortfolioMembership.class, "/portfolio_memberships", "GET");
    }

    /**
     * Returns the compact portfolio membership records for the portfolio.
     *
     * @param  portfolio The portfolio for which to fetch memberships.
     * @return Request object
     */
    public CollectionRequest<PortfolioMembership> findByPortfolio(String portfolio) {

        String path = String.format("/portfolios/%s/portfolio_memberships", portfolio);
        return new CollectionRequest<PortfolioMembership>(this, PortfolioMembership.class, path, "GET");
    }

    /**
     * Returns the portfolio membership record.
     *
     * @param  portfolioMembership Globally unique identifier for the portfolio membership.
     * @return Request object
     */
    public ItemRequest<PortfolioMembership> findById(String portfolioMembership) {

        String path = String.format("/portfolio_memberships/%s", portfolioMembership);
        return new ItemRequest<PortfolioMembership>(this, PortfolioMembership.class, path, "GET");
    }
}
